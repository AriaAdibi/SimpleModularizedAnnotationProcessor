module processor {
  requires annotations;
//  requires static com.google.auto.service;
  requires static java.compiler;

  exports processors;
  provides javax.annotation.processing.Processor with processors.BareProcessor;
}