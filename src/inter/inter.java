package inter;

import bean.assignbean;
import bean.principalshare;
import bean.projectbean;
import bean.stafbean;
import bean.studentbean;
import bean.testpaperbean;

public interface inter  {

	public int staf(stafbean sb);
	 public int stdent(studentbean st);
	 public int principal(principalshare p);
	 public boolean slog(stafbean sl);
	 
	 public int assign(assignbean ab);
	 
	 public boolean stlog(studentbean st);
	 
	 public int test(testpaperbean tpb);
	 
	 public int proj(projectbean pb);
	 
}
