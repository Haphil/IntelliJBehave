/*
 * Copyright 2011-12 Aman Kumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kumaraman21.intellijbehave.resolver;

import com.github.kumaraman21.intellijbehave.parser.JBehaveGivenStories;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.ResolveResult;
import com.intellij.util.ArrayUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GivenStoriesPsiReference implements PsiPolyVariantReference {
    private final JBehaveGivenStories myGivenStory;
    private final TextRange myRange;

    public GivenStoriesPsiReference(JBehaveGivenStories element, TextRange range) {
        myGivenStory = element;
        myRange = range;
    }

    @Override
    public JBehaveGivenStories getElement() {
        return myGivenStory;
    }

    @Override
    public TextRange getRangeInElement() {
        return myRange;
    }

    @Override
    public PsiElement resolve() {
        ResolveResult[] result = multiResolve(true);
        return result.length == 1 ? result[0].getElement() : null;
    }

    @NotNull
    @Override
    public String getCanonicalText() {
        return myGivenStory.getText();
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        return myGivenStory;
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
        return myGivenStory;
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
        ResolveResult[] resolvedResults = multiResolve(false);

        for (ResolveResult resolveResult : resolvedResults) {
            if (getElement().getManager().areElementsEquivalent(resolveResult.getElement(), element)) {
                return true;
            }
        }

        return false;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    @Override
    public boolean isSoft() {
        return false;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        List<ResolveResult> result = new ArrayList<ResolveResult>();
        for (final PsiFile psiFile : myGivenStory.getFiles()) {
            result.add(new ResolveResult() {
                public PsiElement getElement() {
                    return psiFile;
                }

                public boolean isValidResult() {
                    return true;
                }
            });
        }
        return result.toArray(new ResolveResult[result.size()]);
    }
}
