package com.digitalojt.web.consts;

/**
 * 不正文字を管理するEnumクラス
 * 
 * @author Okuma
 */
public enum InvalidCharacter {

	CURLY_BRACE_OPEN('{'),
	CURLY_BRACE_CLOSE('}'),
	PARENTHESIS_OPEN('('),
	PARENTHESIS_CLOSE(')'),
	EQUAL_SIGN('='),
	AMPERSAND('&'),
	SEMICOLON(';'),
	DOLLAR_SIGN('$'),
	QUESTION_MARK('?'),
	ASTERISK('*'),
	HALF_SPACE(' '),
	SINGLE_QUOTATION('\'');

	private final char character;

	/** 
	 * InvalidCharacter列挙型のコンストラクタ
	 *  
	 * @param character 列挙定数が表す文字
	 */

	InvalidCharacter(char character) {
		this.character = character;
	}

	/**
	 * 列挙定数が表す文字を取得
	 *
	 * @return 列挙定数が表す文字 
	 */
	public char getCharacter() {
		return character;
	}
}
