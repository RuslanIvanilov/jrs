package ru.s7.main_frame;

import java.util.HashMap;
import java.util.Map;

public class ConcreteObserver implements Observer{

    private Map<EventName, Subscriber> subscribers = new HashMap<EventName, Subscriber>();

    public void addSubscriber(EventName eventName, Subscriber subscriber){
        subscribers.put(eventName, subscriber);
    }


    @Override
    public void notice(EventType eventType) {
        if(EventType.SUCCESS == eventType){
            for(Subscriber subscriber : subscribers){
                subscriber.event(eventType);
            }
        }
    }
}
