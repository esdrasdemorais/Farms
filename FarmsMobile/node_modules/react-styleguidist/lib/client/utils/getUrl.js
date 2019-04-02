import "core-js/modules/es6.string.anchor";
import "core-js/modules/es6.function.name";

/**
 * Get component / section URL.
 *
 * @param {string} $.name Name
 * @param {string} $.slug Slug
 * @param {number} $.example Example index
 * @param {boolean} $.anchor Anchor?
 * @param {boolean} $.isolated Isolated mode?
 * @param {boolean} $.nochrome No chrome? (Can be combined with anchor or isolated)
 * @param {boolean} $.absolute Absolute URL? (Can be combined with other flags)
 * @param {object} [location] Location object (will use current page location by default)
 * @return {string}
 */
export default function getUrl(_temp, _temp2) {
  var _ref = _temp === void 0 ? {} : _temp,
      name = _ref.name,
      slug = _ref.slug,
      example = _ref.example,
      anchor = _ref.anchor,
      isolated = _ref.isolated,
      nochrome = _ref.nochrome,
      absolute = _ref.absolute,
      hashPath = _ref.hashPath,
      id = _ref.id,
      takeHash = _ref.takeHash;

  var _ref2 = _temp2 === void 0 ? window.location : _temp2,
      origin = _ref2.origin,
      pathname = _ref2.pathname,
      hash = _ref2.hash;

  var url = pathname;

  if (takeHash) {
    if (hash.indexOf('?') > -1) {
      url += hash.substring(0, hash.indexOf('?'));
    } else {
      url += hash;
    }
  }

  if (nochrome) {
    url += '?nochrome';
  }

  if (anchor) {
    url += "#" + slug;
  } else if (isolated || nochrome) {
    url += "#!/" + name;
  }

  if (hashPath) {
    if (!id) {
      hashPath = [].concat(hashPath, [name]);
    }

    url += "#/" + hashPath.join('/');
  }

  if (id) {
    url += "?id=" + slug;
  }

  if (example !== undefined) {
    url += "/" + example;
  }

  if (absolute) {
    return origin + url;
  }

  return url;
}