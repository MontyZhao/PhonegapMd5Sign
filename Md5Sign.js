//���� �ײ�ӿڼ��ܴ���
function Md5Sign(success,error,option){
	cordova.exec(success, error, "Md5Sign", "sign", option);
}	