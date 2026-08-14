class Solution {
public:
    vector<int> addToArrayForm(vector<int>& num, int k) {

        vector<int> ans;

        int p = num.size() - 1;
        int carry = 0;

        while (p >= 0 || k > 0 || carry > 0) {

            int numval = 0;

            if (p >= 0) {
                numval = num[p];
            }

            int d = k % 10;

            int sum = numval + d + carry;

            int digit = sum % 10;
            carry = sum / 10;

            ans.push_back(digit);

            p--;
            k = k / 10;
        }

        reverse(ans.begin(), ans.end());

        return ans;
    }
};