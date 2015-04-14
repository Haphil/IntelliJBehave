package com.github.kumaraman21.intellijbehave.formatter;

import com.github.kumaraman21.intellijbehave.language.JBehaveFileType;
import com.github.kumaraman21.intellijbehave.parser.JBehaveParserDefinition;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelProvider;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.kumaraman21.intellijbehave.parser.IJBehaveElementType.*;

/**
 * Created by DeBritoD on 20.03.2015.
 */
public class StoryFormattingBuilder implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(),
                                                                       new StoryBlock(element.getNode(),
                                                                                      createSpaceBuilder(settings),
                                                                                      createIndents(settings)), null);
    }

    public static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        SpacingBuilder spacingBuilder = new SpacingBuilder(settings, JBehaveFileType.JBEHAVE_FILE_TYPE.getLanguage());

        spacingBuilder.afterInside(
                TokenSet.create(JB_GIVEN_STORIES, JB_DESCRIPTION, JB_META_STATEMENT, JB_SCENARIO, JB_LIFECYCLE,
                                JB_NARRATIVE), JBehaveParserDefinition.STORY_FILE).spacing(0, 0, 2, false, 0);
        //
        spacingBuilder.afterInside(JB_TOKEN_NARRATIVE, JB_NARRATIVE).spacing(0, 0, 1, false, 0);
        //
        spacingBuilder.afterInside(JB_TOKEN_META, JB_META_STATEMENT).spacing(1, 1, 0, false, 0);
        //
        spacingBuilder.afterInside(JB_TOKEN_GIVEN_STORIES, JB_GIVEN_STORIES).spacing(1, 1, 0, false, 0);
        //
        spacingBuilder.afterInside(JB_TOKEN_LIFECYCLE, JB_LIFECYCLE).spacing(0, 0, 1, false, 0);
        //
        spacingBuilder.afterInside(JB_TOKEN_SCENARIO, JB_SCENARIO).spacing(1, 1, 0, false, 0);
        //
        spacingBuilder.afterInside(JB_STORY_PATH, JB_STORY_PATHS).spacing(0, 0, 0, false, 0);
        spacingBuilder.afterInside(JB_TOKEN_COMMA, JB_STORY_PATHS).spacing(0, 0, 1, true, 0);
        //
        spacingBuilder.afterInside(JB_META_ELEMENT, JB_META_STATEMENT).spacing(0, 0, 1, true, 0);
        //Scenario
        spacingBuilder.beforeInside(TokenSet.create(JB_GIVEN_STORIES, JB_META_STATEMENT), JB_SCENARIO)
                      .spacing(0, 0, 1, false, 0);
        spacingBuilder.afterInside(JB_SCENARIO_TITLE, JB_SCENARIO).spacing(0, 0, 1, false, 0);
        spacingBuilder.beforeInside(JB_STEP, JB_SCENARIO).spacing(0, 0, 1, true, 1);
        spacingBuilder.afterInside(JB_STEP, JB_SCENARIO).spacing(0, 0, 1, true, 1);
        spacingBuilder.beforeInside(JB_EXAMPLES, JB_SCENARIO).spacing(0, 0, 2, false, 0);
        //
        spacingBuilder.after(TokenSet.create(JB_STEP_PAR, JB_TOKEN_GIVEN_STORIES)).spacing(1, 1, 0, false, 0);
        spacingBuilder.before(JB_STORY_PATHS).spacing(1, 1, 0, false, 0);
        spacingBuilder.before(JB_TABLE).spacing(0, 0, 1, false, 0);
        //
        spacingBuilder.after(JB_TOKEN_COMMENT).spacing(0, 0, 0, true, 20);
        spacingBuilder.before(JB_TOKEN_COMMENT).spacing(0, 0, 0, true, 20);
        return spacingBuilder;
    }

    private static IndentingMappings createIndents(CodeStyleSettings settings) {
        IndentingMappings indentingMappings = new IndentingMappings(0);
        indentingMappings.putIndent(JB_STORY_PATH, 14);
        indentingMappings.putIndent(JB_META_ELEMENT, 6);
        return indentingMappings;
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}
