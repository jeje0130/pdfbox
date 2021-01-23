package pdfbox;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PdfboxExample1 {
	public static void main(String[] args) {
		// 1) 새로운 PDDocument 객체를 생성 합니다
		PDDocument document = new PDDocument();
		try {
			// 2) 새로운 PDF 페이지 객체를 생성 합니다.
			PDPage page = new PDPage();
			// 3) 새로운 PDF페이지를 생성합니다.
			document.addPage(page);
			
			// 4) PDF에 한글을 입력하기 위해선 폰트를 따로 지정을 해줘야합니다.			
			InputStream fontStream = new FileInputStream("c:/Windows/Fonts/malgun.TTF");
			PDType0Font font = PDType0Font.load(document, fontStream);
			
			// 5) PDF 파일에 글을 입력하기 위해선 PDPageContentStream 객체를 생성합니다.
			PDPageContentStream content = new PDPageContentStream(document, page);
			
			// 6) 글쓰기 내용 시작점 입니다.
			content.beginText();
			content.setFont(font, 12);	// 위에서 설정한 폰트와 크기를 지정합니다.
			
			// 7) 기준점이 왼쪽 하단 모서리를 기점으로(X,Y) 만큼 시작 위치가 변경됩니다.
			content.newLineAtOffset(25, 700);
			
			// 8) 글의 줄 간격을 정해줍니다.
			content.setLeading(14.5f);
			
			// 문서에 추가할 내용을 써보겠습니다.
			String text1 = "Hello 자바!!";
			content.showText(text1);	// 문서에 입력한 문장을 보여주기 위해 showText() 메소드를 써줍니다.
			
			content.newLine();	// 줄을 변경합니다.
			
			String text2 = "Hello PDFBox!!";
			content.showText(text2);
			
			content.endText();	// 글쓰기 내용을 종료합니다.
			content.close();	// 9) 문서를 닫습니다.
			document.save("D:/D_Other/PdfBoxExample1.pdf");	// 10) FDF 파일을 저장합니다.
			
			System.out.println("PDF 파일 생성 완료");		// PDF가 잘 생성 되었는지를 console로 띄웠습니다.
			
			// 11) Chrome 으로 방금 생성한 pdf 파일을 바로 실행해서 확인 합니다.
	      	String fileName = "D:/D_Other/PdfBoxExample1.pdf";
	   		String chrome = "C:/Program Files/Google/Chrome/Application/chrome.exe";
	   		try {
	   			new ProcessBuilder(chrome,fileName).start();
	   		} catch (IOException e) {
	   			e.printStackTrace();
	   		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
