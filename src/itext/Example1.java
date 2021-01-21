package itext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Example1 {	// HelloWorld.PDF 파일을 만드는 예제 입니다.

	public static void main(String[] args) {
		Document document = new Document();	// 1) com.lowagie.text.Document 클래스 인스턴스를 생성합니다.
		try {
			// 2) Writer와 Document 사이의 연관을 맺어줍니다.
			// Writer를 이용해 문서를 하드디스크에 만들 수 있습니다. HelloWorld.PDF 파일을 작성해보겠습니다.
			PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.PDF"));	
			document.open();	// 3)  문서를 오픈합니다.
			document.add(new Paragraph("Hello World"));	// 4) 문서에 내용을 첨부합니다.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			document.close();	// 5) 문서를 닫습니다.
		}
	}
			// 위의 다섯가지 절차를 거치면 HelloWorld.PDF 문서를 생성하실 수가 있습니다.
}
