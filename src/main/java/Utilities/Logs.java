package Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logs {

    /**
     * Initialize Log4j logs
     */
    private Logger Log = Logger.getLogger(Logs.class.getName());


    public void log4PropertiesConfiguration() {
        PropertyConfigurator.configure("src//main//resources//LogConfiguration//Log4j.properties");
        Log.debug("Log4j appender configuration is successful !!");

    }

    /**
     * Print log for the beginning of the test case
     *
     * @param sTestCaseName
     */
    public void runTestCase(String sTestCaseName) {
        Log.info("******************************************************************************************************");
        Log.info("***************************                                                  *************************");

        Log.info("+++++++++++++++++++++++++++" + "        " + sTestCaseName + "           " + "++++++++++++++++++++++++++");

        Log.info("***************************                                                   *************************");
        Log.info("*******************************************************************************************************");
    }

    /**
     * Print log at the end of the test case
     *
     * @param eTestCaseName TestCase Name
     */
    public void endTestCase(String eTestCaseName) {
        Log.info("+++++++++++++++++++++++             " + "-E---N---D-" + "             ++++++++++++++++++++++");
        Log.info("+++++++++++++++++++++++             " + eTestCaseName + "             ++++++++++++++++++++++");
    }

    /**
     * Designates informational messages that highlight the progress of the application
     *
     * @param message String printed in the log
     */
    public void info(String message) {
        Log.info(message);
    }

    /**
     * Designates potentially harmful situations
     *
     * @param message String printed in the log
     */
    public void warn(String message) {
        Log.warn(message);
    }

    /**
     * Designates error events that might still allow the application to continue running
     *
     * @param message Error String printed in the log
     */
    public void error(String message) {
        Log.error(message);
    }

    /**
     * Designates very severe error that will abort the test
     *
     * @param message String printed in the log
     */
    public void fatal(String message) {
        Log.fatal(message);
    }

    /**
     * Designates informational events that most useful to debug
     *
     * @param message String printed in the log
     */
    public void debug(String message) {
        Log.debug(message);
    }

    public static void main(String[] args) {
        Logs log = new Logs();
        log.info(args.toString());
        log.warn(args.toString());
        log.error(args.toString());
        log.fatal(args.toString());
        log.debug(args.toString());

    }
}
