import "core-js/modules/es6.regexp.match";
import walkes from 'walkes';
import rewriteImports from './rewriteImports';
import getAst from './getAst';

var hasImports = function hasImports(code) {
  return !!code.match(/import[\S\s]+?['"]([^'"]+)['"];?/m);
};
/**
 * Replace ECMAScript imports with require() calls
 */


export default function transpileImports(code) {
  // Don't do anything when the code has nothing that looks like an import
  if (!hasImports(code)) {
    return code;
  } // Ignore errors, they should be caught by Buble


  var ast = getAst(code);

  if (!ast) {
    return code;
  }

  var offset = 0;
  walkes(ast, {
    // import foo from 'foo'
    // import 'foo'
    ImportDeclaration: function ImportDeclaration(node) {
      if (node.source) {
        var start = node.start + offset;
        var end = node.end + offset;
        var statement = code.substring(start, end);
        var transpiledStatement = rewriteImports(statement);
        code = code.substring(0, start) + transpiledStatement + code.substring(end);
        offset += transpiledStatement.length - statement.length;
      }
    }
  });
  return code;
}