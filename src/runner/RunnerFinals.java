package runner;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import entries.FinalEntry;
import xls.XlSUtils;

public class RunnerFinals implements Callable<ArrayList<FinalEntry>> {

	public HSSFSheet sh;
	public int year;

	public RunnerFinals(HSSFSheet sh, int year) {
		this.sh = sh;
		this.year = year;
	}

	@Override
	public ArrayList<FinalEntry> call() throws Exception {
		ArrayList<FinalEntry> tobet = XlSUtils.finalsShots(sh, year);
		return tobet;
	}
}