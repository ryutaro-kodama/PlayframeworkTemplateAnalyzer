package ryutaro.kodama.PlayframeworkTemplateAnalyzer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import play.twirl.parser.TreeNodes.Template;
import play.twirl.parser.TreeNodes.TemplateTree;
import play.twirl.parser.TwirlParser;
import play.twirl.parser.TwirlParser.ParseResult;
import play.twirl.parser.TwirlParser.Success;
import scala.collection.Seq;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\ryutaro\\eclipse-workspace\\PlayframeworkTemplateAnalyzer\\res\\sample.scala.html";
		Path p = Paths.get(path);
		byte[] bytes = Files.readAllBytes(p);
		String contents = new String(bytes, StandardCharsets.UTF_8);

		TwirlParser parser = new TwirlParser(false);
		ParseResult result = parser.parse(contents);
		if (result instanceof TwirlParser.Error) {
			System.out.println("Parsing error.");
			return;
		}

		Template template = ((Success) result)._1();
		Seq<TemplateTree> x = template._9();
		System.out.println("OK");
	}
}
