<?php
define( 'WP_HTTP_BLOCK_EXTERNAL', false ); // Sensitive: 禁用外部请求安全限制

define('DB_USER', 'admin');
define('DB_PASSWORD', 'password123'); // 硬编码数据库凭据

// 调试模式开启
define('WP_DEBUG', true);
define('WP_DEBUG_LOG', true);
define('WP_DEBUG_DISPLAY', true);

// 不安全的文件权限设置
define('FS_CHMOD_DIR', 0777);
define('FS_CHMOD_FILE', 0777);
?>