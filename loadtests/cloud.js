import {check, group, sleep} from "k6";
import http from "k6/http";
export let options = {stages: [
		{duration: "10s",target: 30},
		{duration: "20s", target: 30},
		{duration: "10s",target: 5}],
	thresholds: {"http_req_duration": ["p(95)<250"]},
	ext: {loadimpact: {
			projectID: 3483149,
			name: "test.loadimpact.com", distribution: {
		loadZoneLabel1: {loadZone: "amazon:us:ashburn", percent: 100}
		}}}
	};
	
export default function () {
	group("Front page", function () {
		let res = http.get("http://test.loadimpact.com/");
		check(res, {"is status 200": (r) => r.status === 200});
		sleep(5);
	});
}
