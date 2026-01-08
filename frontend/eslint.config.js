module.exports = [
    {
        ignores: ["build/", "node_modules/"],
        languageOptions: {
            ecmaVersion: 2022,
            sourceType: "module",
        },
        rules: {
            "no-console": "warn",
            "no-unused-vars": "warn"
        }
    }
];
