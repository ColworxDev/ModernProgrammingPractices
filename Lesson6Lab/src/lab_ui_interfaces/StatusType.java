package lab_ui_interfaces;

import java.awt.Color;

import lesson6.labs.Util;

public enum StatusType {
	Success, Fail, none;
	 public Color getColor() {
		 switch (this) {
		 case Success:
			 return Util.INFO_MESSAGE_COLOR;
		 case Fail:
			 return Util.ERROR_MESSAGE_COLOR;
		default:
			return Color.black;
		 }
	 }
}