package top.ljjapp.api;

import top.ljjapp.base.Result;

import java.io.Serializable;

/**
 * define an interface for calling wallet
 * the constraint of this interface is that:
 * 1. only contains one method
 * 2. the method only has one parameter, it's not basic class and implements Serializable interface
 * 3. the return parameter should not be basic class too, and it has to implements Serializable interface
 * 4. the return parameter can also be Future<>, the generalization parameter class should be like point 3
 */
public interface WalletPayMoneyService {
	
	Result pay(Integer result);
	
}
