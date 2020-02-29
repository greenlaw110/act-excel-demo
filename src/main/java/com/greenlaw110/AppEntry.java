package com.greenlaw110;

import act.Act;
import act.inject.DefaultValue;
import act.util.Output;
import org.osgl.logging.LogManager;
import org.osgl.logging.Logger;
import org.osgl.mvc.annotation.Before;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.result.ServiceUnavailable;
import osgl.version.Version;
import osgl.version.Versioned;

/**
 * A simple hello world app entry
 *
 * Run this app, try to update some of the code, then
 * press F5 in the browser to watch the immediate change
 * in the browser!
 */
@SuppressWarnings("unused")
@Versioned
public class AppEntry {

    /**
     * Version of this application
     */
    public static final Version VERSION = Version.of(AppEntry.class);

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
