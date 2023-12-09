package com.reactive.homebanking.handlers.bus;


import com.reactive.homebanking.configs.RabbitConfig;
import com.google.gson.Gson;
import com.reactive.homebanking.drivenAdapters.useCases.accountUseCases.SaveAccountUseCase;
import com.reactive.homebanking.drivenAdapters.useCases.clientUseCases.SaveClientUseCase;
import com.reactive.homebanking.drivenAdapters.useCases.errorUseCases.SaveErrorUseCase;
import com.reactive.homebanking.drivenAdapters.useCases.transactionUseCases.SaveTransactionUseCase;
import com.reactive.homebanking.models.Account;
import com.reactive.homebanking.models.Client;
import com.reactive.homebanking.models.ErrorRabbit;
import com.reactive.homebanking.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.rabbitmq.Receiver;

@Component
public class RabbitMqMessageConsumer implements CommandLineRunner {

    @Autowired
    private Receiver receiver;

    @Autowired
    private Gson gson;

    @Autowired
    private SaveAccountUseCase saveAccountUseCase;

    @Autowired
    private SaveClientUseCase saveClientUseCase;

    @Autowired
    private SaveTransactionUseCase saveTransactionUseCase;

    @Autowired
    private SaveErrorUseCase saveErrorUseCase;


    @Override
    public void run(String... args) throws Exception {

        receiver.consumeAutoAck(RabbitConfig.CLIENT_QUEUE)
                .map(message -> {
                   Client client = gson
                           .fromJson(new String(message.getBody()),
                                   Client.class);

                    System.out.println("Client in process:  " + client);
                    saveClientUseCase.saveClient(client).subscribe();
                    return client;
                }).subscribe();

        receiver.consumeAutoAck(RabbitConfig.ACCOUNT_QUEUE)
                .map(message -> {
                    Account account = gson
                            .fromJson(new String(message.getBody()),
                                    Account.class);

                    System.out.println("Account in process:  " + account);
                    saveAccountUseCase.saveAccount(account).subscribe();
                    return account;
                }).subscribe();

        receiver.consumeAutoAck(RabbitConfig.TRANSACTION_QUEUE)
                .map(message -> {
                    Transaction transaction = gson
                            .fromJson(new String(message.getBody()),
                                    Transaction.class);

                    System.out.println("Transaction in process:  " + transaction);
                    saveTransactionUseCase.saveTransaction(transaction).subscribe();
                    return transaction;
                }).subscribe();

        receiver.consumeAutoAck(RabbitConfig.ERROR_QUEUE)
                .map(message -> {
                    ErrorRabbit error = gson
                            .fromJson(new String(message.getBody()),
                                    ErrorRabbit.class);

                    System.out.println("Error in process:  " + error);
                    saveErrorUseCase.saveError(error).subscribe();
                    return error;
                }).subscribe();
    }
}
