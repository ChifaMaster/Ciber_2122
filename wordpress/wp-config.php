<?php

// BEGIN iThemes Security - No modifiques ni borres esta línea
// iThemes Security Config Details: 2
define( 'DISALLOW_FILE_EDIT', true ); // Desactivar editor de archivos - Seguridad > Ajustes > Ajustes WordPress > Editor de archivos
// END iThemes Security - No modifiques ni borres esta línea

/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the installation.
 * You don't have to use the web site, you can copy this file to "wp-config.php"
 * and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://wordpress.org/support/article/editing-wp-config-php/
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'solvetic' );

/** MySQL database username */
define( 'DB_USER', 'Admin' );

/** MySQL database password */
define( 'DB_PASSWORD', 'Admin108' );

/** MySQL hostname */
define( 'DB_HOST', 'localhost' );

/** Database charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8' );

/** The database collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication unique keys and salts.
 *
 * Change these to different unique phrases! You can generate these using
 * the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}.
 *
 * You can change these at any point in time to invalidate all existing cookies.
 * This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         '-DqquWDB;qoE3%&),@L#/+.]sP59PvJi)ff3RG7~3D~$^E``@jkW1|L}q69|M#)z');
define('SECURE_AUTH_KEY',  '_dBrf</_T+OFrNQNI-NBck|nx hkj8+V|=dn~NZr|2qm,QyZA<Dr([+ET5v)0az-');
define('LOGGED_IN_KEY',    'W{5GQ8GkIQM1.(H<qIi`6?@fP5r <vZN A06OUgNbr#@4y-3^0HUxWWQgVk16GZS');
define('NONCE_KEY',        ',ZM-as;m+BI5#iX1CMeHT8rhW>w[dV$%m w4oD<M/LM5$nSw%Vr-]%YMj3+!I9UM');
define('AUTH_SALT',        'TIqLohC%1,L74f+e3Y0~X~Y)+1s_%>_YMQ4tVF{0pB(u@L-9CjaM?q-UY_Il^&C^');
define('SECURE_AUTH_SALT', 'n9]D{,ytj~b:wY^t2COT#Z:+p:,l:&$fl,M+FtA<itUdo)fii:OZsq>,(bnI W13');
define('LOGGED_IN_SALT',   '2?PtMO{<vIt+pMzFg4zP6-L;p#>%:y:^:Fhs|.|lV{))Xob.F(|.>s%il49O!,3.');
define('NONCE_SALT',       '~13^h9cV7I Hz~~cY4[g*d|!GXzls?_CJF)ECb|{@SXggLVoc`Y8G4D[QmO$E@W.');
/**#@-*/
/**#@-*/

/**
 * WordPress database table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://wordpress.org/support/article/debugging-in-wordpress/
 */
define( 'WP_DEBUG', false );

/* Add any custom values between this line and the "stop editing" line. */



/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';


@ini_set('session.cookie_httponly', true); 
@ini_set('session.cookie_secure', true); 
@ini_set('session.use_only_cookies', true);


//securizar con hash las cookies
if ( !defined( 'COOKIEHASH' ) ) {
  $siteurl = get_site_option( 'https://grupo3.com/' );
  if ( $siteurl )
    define( 'COOKIEHASH', md5( $siteurl ) );
  else
    define( 'COOKIEHASH', '' );
}

define( 'COOKIEHASH', 'ZWrSiqP4X2YvFvygXq4SF2eJMdu4VGBIJT2QBUuXKjEmURTBpe5fXIHMoiuMWG6yQB8ja9FsylTH5YvauOFF1N2jCQ7G8CHyfjoV1vQyCxHkaBa6dOSAMl1Xk3Nj39ndQ4SAvWIoV0rxtaiNJ3Wzkv8OKPSdzOvA0H7HDRoDm5NoJBcYwRSY4PhvGYSkuRVnSmkvQJc7lA8Hkgr9xWlVokrrubgS9pVuqqrfQuWyhDZIFGRmC4XSjkPfpAF28kb4' );

if ( !defined('COOKIE_DOMAIN') )
   define('COOKIE_DOMAIN', false);

define('COOKIE_DOMAIN', 'https://grupo3.com');

