package interview.executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import org.apache.log4j.xml.DOMConfigurator;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

public class Program {

	public static void main(String[] args)
			throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException, InterruptedException, URISyntaxException {
		if (args.length > 0)
			launchJar();
		else
			jarRunnable();
	}

	private static void launchJar() throws IOException {
		File file = new File("\\target\\executable-executable-jar-with-dependencies.jar");
		Runtime.getRuntime().exec(new String[] { "java", "-jar", new File(".").getCanonicalPath() + file.getPath() });
		System.exit(0);

	}

	private static void jarRunnable() throws JsonGenerationException, JsonMappingException, FileNotFoundException,
			IOException, InterruptedException, URISyntaxException {
		File file = new File(Program.class.getClassLoader().getResource("log4j2.xml").getFile());
		System.out.println(file.getPath());
		DOMConfigurator.configure(file.getPath());
		CustomerData customer = new CustomerData("Omer", "Regev", 25, " ", " beer sheva ", 10021, "mobile",
				"+972- 547670102");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, true);
		mapper.writeValue(new FileOutputStream("C:\\jsontest.txt", true), customer);
	}

}