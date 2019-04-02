import "core-js/modules/es6.object.assign";
import "core-js/modules/es6.function.name";
import "core-js/modules/es6.regexp.replace";

/**
 * Remove quotes around given string.
 *
 * @param {string} string
 * @returns {string}
 */
export function unquote(string) {
  return string && string.replace(/^['"]|['"]$/g, '');
}
/**
 * Return prop type object.
 *
 * @param {object} prop
 * @returns {object}
 */

export function getType(prop) {
  if (prop.flowType) {
    if (prop.flowType.name === 'union' && prop.flowType.elements.every(function (elem) {
      return elem.name === 'literal';
    })) {
      return Object.assign({}, prop.flowType, {
        name: 'enum',
        value: prop.flowType.elements
      });
    }

    return prop.flowType;
  }

  return prop.type;
}
/**
 * Show starting and ending whitespace around given string.
 *
 * @param {string} string
 * @returns {string}
 */

export function showSpaces(string) {
  return string && string.replace(/^\s|\s$/g, '␣');
}