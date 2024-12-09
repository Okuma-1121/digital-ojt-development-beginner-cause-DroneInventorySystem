package com.digitalojt.web.consts;
/**
 * 分類 Enumクラス
 * 
 * @author Okuma
 */
public enum CategoryConsts {

	FRAME("フレーム"),
	PROPELLER("プロペラ"),
	ELECTRICMOTOR("電動モーター"),
	ELECTRICSPEEDREGULATOR("電子速度調整器"),
	BATTERY("バッテリー"),
	FLIGHTCONTROLLER("フライトコントローラー"),
	REMOTECONTROLLER("リモートコントローラー"),	
	RECEIVER("受信機"),
	GPSMODULE("GPSモジュール"),
	CAMERASENSOR("カメラ／センサー");
	
	private final String category;

	CategoryConsts(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
