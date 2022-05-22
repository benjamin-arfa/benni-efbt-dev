/*
 * generated by Xtext 2.26.0
 */
package org.eclipse.efbt.openregspecs.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.efbt.openregspecs.parser.antlr.internal.InternalOpenRegSpecsDSLParser;
import org.eclipse.efbt.openregspecs.services.OpenRegSpecsDSLGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class OpenRegSpecsDSLParser extends AbstractAntlrParser {

	@Inject
	private OpenRegSpecsDSLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalOpenRegSpecsDSLParser createParser(XtextTokenStream stream) {
		return new InternalOpenRegSpecsDSLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "BIRDModel";
	}

	public OpenRegSpecsDSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(OpenRegSpecsDSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
