package top.qiuk.constant;

/**
 * 日志类型
 * @author 邱凯
 *
 */
public enum LogTypeEnum {

	INSERT(0),UPDATE(1),DELETE(2);
	
	private int value;
	
	private LogTypeEnum(int i) {
		value = i;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
