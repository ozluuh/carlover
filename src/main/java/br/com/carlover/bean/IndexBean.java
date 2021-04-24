package br.com.carlover.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class IndexBean {

    public void execute() {
        System.out.println("If you see this in the log, you have been successful");
    }
}
