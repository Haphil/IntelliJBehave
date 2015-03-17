// This is a generated file. Not intended for manual editing.
package com.github.kumaraman21.intellijbehave.psi.impl;

import com.github.kumaraman21.intellijbehave.psi.StoryStepPostParameter;
import com.github.kumaraman21.intellijbehave.psi.StoryStoryPath;
import com.github.kumaraman21.intellijbehave.psi.StoryTable;
import com.github.kumaraman21.intellijbehave.psi.StoryVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.kumaraman21.intellijbehave.parser.IStoryPegElementType.STORY_TOKEN_NEWLINE;

public class StoryStepPostParameterImpl extends ASTWrapperPsiElement implements StoryStepPostParameter {

  public StoryStepPostParameterImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StoryVisitor) ((StoryVisitor)visitor).visitStepPostParameter(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public StoryStoryPath getStoryPath() {
    return findChildByClass(StoryStoryPath.class);
  }

  @Override
  @Nullable
  public StoryTable getTable() {
    return findChildByClass(StoryTable.class);
  }

  @Override
  @Nullable
  public PsiElement getTokenNewline() {
    return findChildByType(STORY_TOKEN_NEWLINE);
  }

}
