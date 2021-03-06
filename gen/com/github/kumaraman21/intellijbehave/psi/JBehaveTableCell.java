// This is a generated file. Not intended for manual editing.
package com.github.kumaraman21.intellijbehave.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface JBehaveTableCell extends PsiElement {

  @NotNull
  List<JBehaveIpAddress> getIpAddressList();

  @NotNull
  List<JBehaveMetaElement> getMetaElementList();

  @NotNull
  List<JBehaveStoryPath> getStoryPathList();

  @NotNull
  List<JBehaveUri> getUriList();

}
