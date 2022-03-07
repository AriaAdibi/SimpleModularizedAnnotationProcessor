module processor {
  requires static annotations;
  requires static com.google.auto.service;
  requires static java.compiler;

  provides javax.annotation.processing.Processor with processors.BareProcessor;
}