/*
 * generated by Xtext 2.23.0
 */
package org.eclipse.efbt.cocason.dsl.cocason.tests

import com.google.inject.Inject
import org.eclipse.efbt.cocamo.smcubes.model.cocamo.Program
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(CoCaSonInjectorProvider)
class CoCaSonParsingTest {
	@Inject
	ParseHelper<Program> parseHelper
	
	@Test
	def void loadModel() {
		
		Assertions.assertTrue(true)
	}
}
