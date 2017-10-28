package org.mockitocheckstyle;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class DeprecationCommentsCheck extends AbstractCheck {
    @Override
    public int[] getDefaultTokens() {
        return this.getAcceptableTokens();
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[]{TokenTypes.CLASS_DEF, TokenTypes.INTERFACE_DEF, TokenTypes.ANNOTATION_DEF};
    }

    @Override
    public int[] getRequiredTokens() {
        return this.getAcceptableTokens();
    }

    @Override
    public void visitToken(DetailAST ast) {
        DetailAST commentBlock = ast.findFirstToken(TokenTypes.COMMENT_CONTENT);
        System.out.println(commentBlock);
    }
}
