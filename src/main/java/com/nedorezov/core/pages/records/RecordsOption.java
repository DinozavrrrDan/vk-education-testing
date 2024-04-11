package com.nedorezov.core.pages.records;

public enum RecordsOption {
    DELETE("Удалить"),
    EDIT("Редактировать"),
    TURN_OF_COMMENTS("Отключить комментирование");
    private final String option;

    RecordsOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return this.option;
    }
}
