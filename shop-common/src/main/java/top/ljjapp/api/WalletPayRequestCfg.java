package top.ljjapp.api;

import com.yiqiniu.easytrans.protocol.BusinessIdentifer;
import com.yiqiniu.easytrans.protocol.tcc.TccMethodRequest;
import top.ljjapp.base.Result;

/**
 * define the calling configuration for WalletPayMoneyService
 */
@BusinessIdentifer(appId=WalletServiceApiConstant.APPID,busCode="pay",rpcTimeOut=2000)
public class WalletPayRequestCfg extends WalletPayMoneyService.WalletPayRequestVO
		implements TccMethodRequest<WalletPayMoneyService.WalletPayResponseVO> {
	private static final long serialVersionUID = 1L;
}
