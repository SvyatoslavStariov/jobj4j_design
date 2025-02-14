package ru.job4j.ood.lsp;

/**
 * Нарушения принципа LSP. Наследник изменяет постусловие.
 */
public class EngineerCommunications extends Engineer {

    @Override
    public void drawProduct() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String designsProduct() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
