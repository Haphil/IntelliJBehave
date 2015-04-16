// This is a generated file. Not intended for manual editing.
package com.github.kumaraman21.intellijbehave.psi.impl;

import com.github.kumaraman21.intellijbehave.parser.ParserRule;
import com.github.kumaraman21.intellijbehave.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JBehaveTableCellImpl extends ParserRule implements JBehaveTableCell {

    public JBehaveTableCellImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof JBehaveVisitor) ((JBehaveVisitor) visitor).visitTableCell(this);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<JBehaveIpAddress> getIpAddressList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, JBehaveIpAddress.class);
    }

    @Override
    @Nullable
    public JBehaveMetaElement getMetaElement() {
        return findChildByClass(JBehaveMetaElement.class);
    }

    @Override
    @NotNull
    public List<JBehaveStoryPath> getStoryPathList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, JBehaveStoryPath.class);
    }

    @Override
    @NotNull
    public List<JBehaveUri> getUriList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, JBehaveUri.class);
    }

}