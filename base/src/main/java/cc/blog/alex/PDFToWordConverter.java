package cc.blog.alex;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * <P></p>
 *
 * @author lijiang
 * @since 2024/3/19 下午2:42
 */
public class PDFToWordConverter {

    public static void main(String[] args) throws IOException {

        // String pdfPath = "/home/alex/IdeaProjects/learn-java/docs/base";
        //
        // Path path = Paths.get(pdfPath);
        // Stream<Path> walk = Files.walk(path);
        // walk.forEach(System.out::println);
        //
        // walk.forEach(
        //         path1 -> {
        //             System.out.println(path1);
        //         }
        // );
        // Files.walk(new File(pdfPath).toPath())

        try {
            // Load PDF document
            PDDocument pdfDocument = PDDocument.load(new File("/home/alex/IdeaProjects/learn-java/docs/base/尚硅谷_宋红康_第4章_面向对象编程(上).pdf"));

            // Create Word document
            XWPFDocument wordDocument = new XWPFDocument();

            // Extract text from PDF
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(pdfDocument);

            // Add text to Word document
            XWPFParagraph paragraph = wordDocument.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText(text);

            // Save Word document
            FileOutputStream out = new FileOutputStream(new File("output.docx"));
            wordDocument.write(out);
            out.close();

            // Close documents
            pdfDocument.close();
            wordDocument.close();

            System.out.println("PDF converted to Word successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
