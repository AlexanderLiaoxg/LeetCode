package com.cbry.mybatis.plus;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "mp_user") //默认将类名作为表名
public class MPUserPoJo {
	String uid;
	String uname;
	int uage;
	@TableField(value = "create_time")
	Date createTime;
}
