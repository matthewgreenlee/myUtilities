package com.goldenpond.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import com.goldenpond.utils.Print;

public class InstallerOptions {

	private static final String HELP = "help";
	private static final String ADMIN_CREDENTIALS = "admin_credentials";
	private static final String HTTPS_BIND_ADDRESS = "https_bind_address";
	private static final String DISABLE_HTTP = "disable_http";
	private static final String BIND_ADDRESS = "bind_address";
	private static final String INSTALLATION_DIR = "installation_dir";
	private static final String SERVER = "server";

	private CommandLine commandLine;

	public InstallerOptions(String[] args) {
		Options options = new Options();

		Option help = OptionBuilder.create(HELP);
		options.addOption(help);

		String[] newArgs = new String[args.length - 1];
		for (int i = 1; i < args.length; i++) {
			newArgs[i-1] = "--" + args[i];
		}

		OptionBuilder.withArgName(SERVER);
		OptionBuilder.hasArg(false);
		Option server = OptionBuilder.create(SERVER);
		options.addOption(server);

		OptionBuilder.withArgName(INSTALLATION_DIR);
		OptionBuilder.hasArgs();
		Option installation_dir = OptionBuilder.create(INSTALLATION_DIR);
		options.addOption(installation_dir);
		
		OptionBuilder.withArgName(BIND_ADDRESS);
		OptionBuilder.hasArg();
		Option bind_address = OptionBuilder.create(BIND_ADDRESS);
		options.addOption(bind_address);

		OptionBuilder.withArgName(DISABLE_HTTP);
		OptionBuilder.hasArg(false);
		Option disable_http = OptionBuilder.create(DISABLE_HTTP);
		options.addOption(disable_http);
		
		OptionBuilder.withArgName(HTTPS_BIND_ADDRESS);
		OptionBuilder.hasArg();
		Option https_bind_address = OptionBuilder.create(HTTPS_BIND_ADDRESS);
		options.addOption(https_bind_address);

		OptionBuilder.withArgName(ADMIN_CREDENTIALS);
		OptionBuilder.hasArg();
		Option admin_credentials = OptionBuilder.create(ADMIN_CREDENTIALS);
		options.addOption(admin_credentials);

		CommandLineParser parser = new PosixParser();
		try {
			commandLine = parser.parse(options, newArgs);
		} catch (ParseException e) {
			Print.ln("please make sure your command was in correct format");
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	public String getInstallationDir() {
		return commandLine.getOptionValue(INSTALLATION_DIR);
	}

	public String getBindAddress() {
		return commandLine.getOptionValue(BIND_ADDRESS);
	}

	public boolean isDisableHttp() {
		return commandLine.hasOption(DISABLE_HTTP);
	}

	public String getHttpsBindAddress() {
		return commandLine.getOptionValue(HTTPS_BIND_ADDRESS);
	}

	public String getHttpsBindAddressHost() {
		return getHttpsBindAddress().split(":")[0];
	}

	public String getHttpsBindAddressPort() {
		return getHttpsBindAddress().split(":")[1];
	}

	public String getAdminCredentials() {
		return commandLine.getOptionValue(ADMIN_CREDENTIALS);
	}

	public static void main(String[] args) {
		args = new String[] { "--install", "server",
				"installation_dir=D:/dynatrace", "bind_address=0.0.0.0:8899",
				"disable_http", "https_bind_address=0.0.0.0:443",
				"admin_credentials=admin/admin" };
		InstallerOptions opts = new InstallerOptions(args);
		Print.ln(opts.getInstallationDir());
		Print.ln(opts.getBindAddress());
		Print.ln(opts.isDisableHttp());
		Print.ln(opts.getHttpsBindAddress());
		Print.ln(opts.getHttpsBindAddressHost());
		Print.ln(opts.getHttpsBindAddressPort());
		Print.ln(opts.getAdminCredentials());
	}

}
