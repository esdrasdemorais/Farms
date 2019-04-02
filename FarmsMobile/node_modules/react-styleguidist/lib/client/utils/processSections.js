import "core-js/modules/es6.function.name";
import "core-js/modules/es6.object.assign";
import processComponents from './processComponents';
/**
 * Recursively process each component in all sections.
 *
 * @param {Array} sections
 * @return {Array}
 */

export default function processSections(sections) {
  return sections.map(function (section) {
    return Object.assign({}, section, {
      visibleName: section.name,
      components: processComponents(section.components || []),
      sections: processSections(section.sections || [])
    });
  });
}