package co.hj.prj.board.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	
	private int boardId;
	private String boardName;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardHit;	

}
