//调用 底层接口加密处理
function Md5Sign(success,error,option){
	cordova.exec(success, error, "Md5Sign", "sign", option);
}	