/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author aw
 */
public interface Servico extends Remote{
    public byte[] aplicacao(byte[] data) throws RemoteException, IOException;
}