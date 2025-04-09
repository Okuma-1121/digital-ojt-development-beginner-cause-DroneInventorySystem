package com.digitalojt.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitalojt.web.entity.CenterInfo;
import com.digitalojt.web.form.DeleteCenterInfoForm;
import com.digitalojt.web.form.RegisterCenterInfoForm;
import com.digitalojt.web.form.UpdateCenterInfoForm;
import com.digitalojt.web.repository.CenterInfoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 在庫センター情報画面のサービスクラス
 *
 * @author Okuma
 * 
 */
@Service
@RequiredArgsConstructor
public class CenterInfoService {

	/** センター情報テーブル リポジトリー */
	private final CenterInfoRepository repository;

	/**
	 * 在庫センター情報を全建検索で取得
	 * 
	 * @return
	 */
	public List<CenterInfo> getCenterInfoData() {
		return repository.findAll();
	}

	/**
	 * 引数に合致する在庫センター情報を取得
	 * 
	 * @param centerName
	 * @param region 
	 * @param storageCapacityFrom 
	 * @param storageCapacityTo
	 * @return
	 */
	public List<CenterInfo> getCenterInfoData(String centerName, String region) {
		return repository.findByCenterNameAndRegionAndStorageCapacity(centerName, region);
	}

	/**
	 * 在庫センター情報を登録
	 * 
	 * @param form
	 */
	@Transactional(rollbackForClassName = { "Exception" })
	public void registerCenterInfo(RegisterCenterInfoForm form) {
		// 在庫センター情報を登録するためのCenterInfoオブジェクトを作成
		CenterInfo centerInfo = new CenterInfo();
		centerInfo.setCenterName(form.getCenterName());
		centerInfo.setPostCode(form.getPostCode());
		centerInfo.setAddress(form.getAddress());
		centerInfo.setPhoneNumber(form.getPhoneNumber());
		centerInfo.setManagerName(form.getManagerName());
		centerInfo.setOperationalStatus(form.getOperationalStatus());
		centerInfo.setMaxStorageCapacity(form.getMaxStorageCapacity());
		centerInfo.setCurrentStorageCapacity(form.getCurrentStorageCapacity());
		centerInfo.setNotes(form.getNotes());

		repository.save(centerInfo);
	}

	/**
	 * センターIDに合致する在庫センター情報を取得
	 * 
	 * @param centerId
	 * @return
	 */
	public List<CenterInfo> getCenterInfoData(int centerId) {
		return repository.findByCenterId(centerId);
	}

	/**
	 * センターIDに合致する在庫センター情報を更新
	 * 
	 * @param form
	 */
	@Transactional(rollbackForClassName = { "Exception" })
	public void updateCenterInfo(UpdateCenterInfoForm form) {
		// 在庫センター情報を更新するためのCenterInfoオブジェクトを作成
		CenterInfo centerInfo = new CenterInfo();
		centerInfo.setCenterId(form.getCenterId());
		centerInfo.setDeleteFlag(form.getDeleteFlag());
		centerInfo.setCenterName(form.getCenterName());
		centerInfo.setPostCode(form.getPostCode());
		centerInfo.setAddress(form.getAddress());
		centerInfo.setPhoneNumber(form.getPhoneNumber());
		centerInfo.setManagerName(form.getManagerName());
		centerInfo.setOperationalStatus(form.getOperationalStatus());
		centerInfo.setMaxStorageCapacity(form.getMaxStorageCapacity());
		centerInfo.setCurrentStorageCapacity(form.getCurrentStorageCapacity());
		centerInfo.setNotes(form.getNotes());

		repository.save(centerInfo);
	}

	/**
	 * センターIDに合致する在庫センター情報を削除(論理削除)
	 * 
	 * @param form
	 */
	@Transactional(rollbackForClassName = { "Exception" })
	public void deleteCenterInfo(DeleteCenterInfoForm form) {
		// 在庫センター情報を更新するためのCenterInfoオブジェクトを作成
		CenterInfo centerInfo = new CenterInfo();
		centerInfo.setCenterId(form.getCenterId());
		centerInfo.setDeleteFlag("1");//論理削除＝１
		centerInfo.setCenterName(form.getCenterName());
		centerInfo.setPostCode(form.getPostCode());
		centerInfo.setAddress(form.getAddress());
		centerInfo.setPhoneNumber(form.getPhoneNumber());
		centerInfo.setManagerName(form.getManagerName());
		centerInfo.setOperationalStatus(form.getOperationalStatus());
		centerInfo.setMaxStorageCapacity(form.getMaxStorageCapacity());
		centerInfo.setCurrentStorageCapacity(form.getCurrentStorageCapacity());
		centerInfo.setNotes(form.getNotes());

		repository.save(centerInfo);
	}
}