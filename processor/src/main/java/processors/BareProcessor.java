package processors;

import com.google.auto.service.AutoService;
import customannotations.Epilogue;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("customannotations.Epilogue")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
@AutoService(Processor.class)
public class BareProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

    for ( TypeElement annotation : annotations ) {
      for( Element element : roundEnv.getElementsAnnotatedWith(annotation) ) {

        int nLines = element.getAnnotation(Epilogue.class).nLines();
        System.err.println("********** Succeeded::" + nLines);

      }
    }

    return false;

  }

}
