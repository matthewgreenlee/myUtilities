package com.goldenpond.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class InstallerOptions {

	private CommandLine line;

	public InstallerOptions(String[] args) {
		Options options = new Options();
		Option help = OptionBuilder.create("help");
		options.addOption(help);
		String[] newArgs = new String[args.length-1];
		for (int i=1 ; i<args.length ; i++) {
			newArgs[i-1] = "--" + args[i];
		}
		Option server = OptionBuilder.withArgName("server")
				.hasArg(false)
				.create("server");
		Option installation_dir = OptionBuilder.withArgName("installation_dir")
				.hasArgs(2)
				.create("installation_dir");
		Option bind_address = OptionBuilder.withArgName("bind_address")
				.hasArgs(2)
				.create("bind_address");
		Option disable_http = OptionBuilder.withArgName("disable_http")
				.hasArg(false)
				.create("disable_http");
		Option https_bind_address = OptionBuilder.withArgName("https_bind_address")
				.hasArgs(2)
				.create("https_bind_address");
		Option admin_credentials = OptionBuilder.withArgName("admin_credentials")
				.hasArgs(2)
				.create("admin_credentials");

		options.addOption(server);
		options.addOption(installation_dir);
		options.addOption(bind_address);
		options.addOption(disable_http);
		options.addOption(https_bind_address);
		options.addOption(admin_credentials);
		
		CommandLineParser parser = new PosixParser();
		try {
			line = parser.parse(options, newArgs);
		} catch (ParseException e) {
			System.out.println("please make sure your command was in correct format");
			e.printStackTrace();
		}
	}

	public String getInstallationDir() {
		return line.getOptionValue("installation_dir");
	}

	public String getBindAddress() {
		return line.getOptionValue("bind_address");
	}

	public boolean isDisableHttp() {
		return line.hasOption("disable_http");
	}

	public String getHttpsBindAddress() {
		return line.getOptionValue("https_bind_address");
	}

	public String getAdminCredentials() {
		return line.getOptionValue("admin_credentials");
	}

	public static void main(String[] args) {
		InstallerOptions psmArgs = new InstallerOptions(args);
		System.out.println(psmArgs.getInstallationDir());
		System.out.println(psmArgs.getBindAddress());
		System.out.println(psmArgs.isDisableHttp());
		System.out.println(psmArgs.getHttpsBindAddress());
		System.out.println(psmArgs.getAdminCredentials());
	}

}
