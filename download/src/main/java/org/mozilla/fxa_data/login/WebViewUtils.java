/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fxa_data.login;

import android.os.Build;
import android.support.annotation.UiThread;
import android.webkit.WebView;

class WebViewUtils {

    private WebViewUtils() {}

    /**
     * Evaluates JavaScript code in an API-level independent way.
     *
     * Note: all WebView methods must be called from the UIThread.
     */
    @UiThread
    static void evalJS(final WebView webView, final String script) {
        // implementation via http://stackoverflow.com/a/30828985/
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript(script, null);
        } else {
            webView.loadUrl("javascript:" + script);
        }
    }
}
