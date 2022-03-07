package processors;

//import com.google.auto.service.AutoService;
import customannotations.Epilogue;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes("customannotations.Epilogue")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
//@AutoService(Processor.class)
public class BareProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

    for ( TypeElement annotation : annotations ) {
      for( Element element : roundEnv.getElementsAnnotatedWith(annotation) ) {

        int nLines = element.getAnnotation(Epilogue.class).nLines();
        System.err.println("Succeeded::" + nLines);

        JavaFileObject jFile = null;
        try {
          jFile = processingEnv.getFiler().createSourceFile("abc." +
              "Hey");
        } catch (IOException e) {
          e.printStackTrace();
        }
        try(PrintWriter out = new PrintWriter(jFile.openWriter())) {

          out.print(
              "package abc;\n\n" +
              "public class Hey {\n" +
              "   public static void main(String[] args) {\n" +
              "       System.out.println(\"HeyHey\");\n" +
              "   }\n" +
              "}"
          );

        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }

    return false;

  }

}
