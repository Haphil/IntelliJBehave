// This is a generated file. Not intended for manual editing.
package com.github.kumaraman21.intellijbehave.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.kumaraman21.intellijbehave.parser.IStoryPegElementType.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.kumaraman21.intellijbehave.psi.*;

public class StoryMetaElementImpl extends ASTWrapperPsiElement implements StoryMetaElement {

  public StoryMetaElementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StoryVisitor) ((StoryVisitor)visitor).visitMetaElement(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public StoryMetaKey getMetaKey() {
    return findNotNullChildByClass(StoryMetaKey.class);
  }

  @Override
  @NotNull
  public StoryMetaValue getMetaValue() {
    return findNotNullChildByClass(StoryMetaValue.class);
  }

  @Override
  @NotNull
  public PsiElement getTokenSpace() {
    return findNotNullChildByType(STORY_TOKEN_SPACE);
  }

}
