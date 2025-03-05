package ru.job4j.ood.isp.payment;

/**
 * PaymentProcessor заставляет все реализации поддерживать онлайн и офлайн платежи, даже если они их не используют.
 * Объявить пустой PaymentProcessor, с интерфейсом OnlinePayment и OfflinePayment его имплементирующими это будет решение проблемы ISP.
 */
public interface PaymentProcessor {

    void processOnlinePayment();

    void processOfflinePayment();
}
