package com.betrayal.finance.scripts.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException(){
        super("Ошибка! Объект не найден");
    }
    public NotFoundException(String message){
        super(message);
    }
}
