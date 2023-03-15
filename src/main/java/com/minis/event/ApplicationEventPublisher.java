package com.minis.event;

/**
 * @author exccedy
 * @date 2023/3/15
 **/
public interface ApplicationEventPublisher {
    /**
     * 发布监听
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
